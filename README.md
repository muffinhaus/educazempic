<p align="center"><a href="https://laravel.com" target="_blank"><img src="https://raw.githubusercontent.com/laravel/art/master/logo-lockup/5%20SVG/2%20CMYK/1%20Full%20Color/laravel-logolockup-cmyk-red.svg" width="400" alt="Laravel Logo"></a></p>

<p align="center">
<a href="https://github.com/laravel/framework/actions"><img src="https://github.com/laravel/framework/workflows/tests/badge.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/dt/laravel/framework" alt="Total Downloads"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/v/laravel/framework" alt="Latest Stable Version"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/l/laravel/framework" alt="License"></a>
</p>

## About Laravel

Laravel is a web application framework with expressive, elegant syntax. We believe development must be an enjoyable and creative experience to be truly fulfilling. Laravel takes the pain out of development by easing common tasks used in many web projects, such as:

- [Simple, fast routing engine](https://laravel.com/docs/routing).
- [Powerful dependency injection container](https://laravel.com/docs/container).
- Multiple back-ends for [session](https://laravel.com/docs/session) and [cache](https://laravel.com/docs/cache) storage.
- Expressive, intuitive [database ORM](https://laravel.com/docs/eloquent).
- Database agnostic [schema migrations](https://laravel.com/docs/migrations).
- [Robust background job processing](https://laravel.com/docs/queues).
- [Real-time event broadcasting](https://laravel.com/docs/broadcasting).

Laravel is accessible, powerful, and provides tools required for large, robust applications.

## Learning Laravel

Laravel has the most extensive and thorough [documentation](https://laravel.com/docs) and video tutorial library of all modern web application frameworks, making it a breeze to get started with the framework.

You may also try the [Laravel Bootcamp](https://bootcamp.laravel.com), where you will be guided through building a modern Laravel application from scratch.

If you don't feel like reading, [Laracasts](https://laracasts.com) can help. Laracasts contains thousands of video tutorials on a range of topics including Laravel, modern PHP, unit testing, and JavaScript. Boost your skills by digging into our comprehensive video library.

## Laravel Sponsors

We would like to extend our thanks to the following sponsors for funding Laravel development. If you are interested in becoming a sponsor, please visit the [Laravel Partners program](https://partners.laravel.com).

### Premium Partners

- **[Vehikl](https://vehikl.com/)**
- **[Tighten Co.](https://tighten.co)**
- **[WebReinvent](https://webreinvent.com/)**
- **[Kirschbaum Development Group](https://kirschbaumdevelopment.com)**
- **[64 Robots](https://64robots.com)**
- **[Curotec](https://www.curotec.com/services/technologies/laravel/)**
- **[Cyber-Duck](https://cyber-duck.co.uk)**
- **[DevSquad](https://devsquad.com/hire-laravel-developers)**
- **[Jump24](https://jump24.co.uk)**
- **[Redberry](https://redberry.international/laravel/)**
- **[Active Logic](https://activelogic.com)**
- **[byte5](https://byte5.de)**
- **[OP.GG](https://op.gg)**

## Contributing

Thank you for considering contributing to the Laravel framework! The contribution guide can be found in the [Laravel documentation](https://laravel.com/docs/contributions).

## Code of Conduct

In order to ensure that the Laravel community is welcoming to all, please review and abide by the [Code of Conduct](https://laravel.com/docs/contributions#code-of-conduct).

## Security Vulnerabilities

If you discover a security vulnerability within Laravel, please send an e-mail to Taylor Otwell via [taylor@laravel.com](mailto:taylor@laravel.com). All security vulnerabilities will be promptly addressed.

## License

The Laravel framework is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).


🧭 FASE 1 — CRUD completo con Laravel + Blade
🎯 Proyecto: CRUD de Tareas (Tasks)

Vamos a construir:

Listado de tareas
Crear tarea
Editar tarea
Eliminar tarea
🧱 PASO 1 — Crear modelo + migración + controlador

En tu proyecto Laravel:

php artisan make:model Task -mcr

Esto crea:

Modelo (Task.php)
Migración
Controlador con métodos CRUD
🗄️ PASO 2 — Definir la base de datos

Abre la migración (database/migrations/...create_tasks_table.php):

public function up()
{
    Schema::create('tasks', function (Blueprint $table) {
        $table->id();
        $table->string('title');
        $table->text('description')->nullable();
        $table->boolean('completed')->default(false);
        $table->timestamps();
    });
}

Ejecuta:

php artisan migrate
🧠 PASO 3 — Modelo

app/Models/Task.php

protected $fillable = ['title', 'description', 'completed'];
🌐 PASO 4 — Rutas (MUY IMPORTANTE)

routes/web.php

use App\Http\Controllers\TaskController;

Route::resource('tasks', TaskController::class);

👉 Esto crea automáticamente:

GET /tasks
GET /tasks/create
POST /tasks
etc.
🎮 PASO 5 — Controlador (lógica)

app/Http/Controllers/TaskController.php

INDEX (listar)
public function index()
{
    $tasks = Task::all();
    return view('tasks.index', compact('tasks'));
}
CREATE (formulario)
public function create()
{
    return view('tasks.create');
}
STORE (guardar)
public function store(Request $request)
{
    $request->validate([
        'title' => 'required|max:255',
    ]);

    Task::create($request->all());

    return redirect()->route('tasks.index');
}
EDIT
public function edit(Task $task)
{
    return view('tasks.edit', compact('task'));
}
UPDATE
public function update(Request $request, Task $task)
{
    $request->validate([
        'title' => 'required|max:255',
    ]);

    $task->update($request->all());

    return redirect()->route('tasks.index');
}
DELETE
public function destroy(Task $task)
{
    $task->delete();
    return redirect()->route('tasks.index');
}
🎨 PASO 6 — Vistas Blade

Crea carpeta:

resources/views/tasks/
📄 index.blade.php
<h1>Lista de tareas</h1>

<a href="{{ route('tasks.create') }}">Nueva tarea</a>

<ul>
@foreach($tasks as $task)
    <li>
        {{ $task->title }}

        <a href="{{ route('tasks.edit', $task) }}">Editar</a>

        <form action="{{ route('tasks.destroy', $task) }}" method="POST">
            @csrf
            @method('DELETE')
            <button type="submit">Eliminar</button>
        </form>
    </li>
@endforeach
</ul>
➕ create.blade.php
<h1>Crear tarea</h1>

<form action="{{ route('tasks.store') }}" method="POST">
    @csrf

    <input type="text" name="title" placeholder="Título">
    <textarea name="description"></textarea>

    <button type="submit">Guardar</button>
</form>
✏️ edit.blade.php
<h1>Editar tarea</h1>

<form action="{{ route('tasks.update', $task) }}" method="POST">
    @csrf
    @method('PUT')

    <input type="text" name="title" value="{{ $task->title }}">
    <textarea name="description">{{ $task->description }}</textarea>

    <button type="submit">Actualizar</button>
</form>
🚀 PASO 7 — Probar

Arranca:

php artisan serve

Ve a:

http://127.0.0.1:8000/tasks
🧠 LO QUE ESTÁS APRENDIENDO (clave real)

Aquí está lo importante de verdad:

🔁 Flujo completo backend → frontend (Blade)
📦 MVC real
🧾 Formularios con CSRF
✅ Validaciones
🔗 Rutas REST profesionales

👉 Esto es EXACTAMENTE lo que hay en empresas (antes de meter React).

✅ 1. VALIDACIONES BIEN HECHAS (Form Request)

En vez de validar en el controlador:

php artisan make:request StoreTaskRequest

Dentro:

public function rules()
{
    return [
        'title' => 'required|max:255',
        'description' => 'nullable',
    ];
}

En el controlador:

public function store(StoreTaskRequest $request)
{
    Task::create($request->validated());
    return redirect()->route('tasks.index');
}

👉 Esto es MUY importante en empresas.

🎯 2. MENSAJES FLASH (UX real)

En store, update, delete:

return redirect()->route('tasks.index')
    ->with('success', 'Tarea creada correctamente');

En Blade (index.blade.php):

@if(session('success'))
    <p style="color: green;">
        {{ session('success') }}
    </p>
@endif
☑️ 3. COMPLETAR TAREA (lógica real)

Añade checkbox en edit:

<input type="checkbox" name="completed" value="1"
    {{ $task->completed ? 'checked' : '' }}>

En update:

$task->update([
    'title' => $request->title,
    'description' => $request->description,
    'completed' => $request->has('completed'),
]);
🧠 4. MEJORAR LISTADO

En index:

@foreach($tasks as $task)
    <li>
        @if($task->completed)
            <s>{{ $task->title }}</s>
        @else
            {{ $task->title }}
        @endif
    </li>
@endforeach

👉 Ya estás aplicando lógica visual (muy importante).

🛡️ 5. CONFIRMACIÓN AL BORRAR
<form ... onsubmit="return confirm('¿Seguro que quieres eliminar esta tarea?')">
🔐 6. (CLAVE) SIGUIENTE PASO REAL: AUTENTICACIÓN

Aquí empieza lo serio de verdad.

php artisan breeze:install
npm install && npm run dev
php artisan migrate

👉 Esto te da:

Login
Register
Sesiones
Protección de rutas
🔒 PROTEGER TU CRUD
Route::middleware('auth')->group(function () {
    Route::resource('tasks', TaskController::class);
});
🧠 NIVEL EMPRESA (MUY IMPORTANTE)

El siguiente salto mental que debes hacer:

👉 Ahora mismo tus tareas son globales
👉 En empresa: cada usuario tiene sus tareas

🧩 Relación usuario → tareas

En modelo Task:

public function user()
{
    return $this->belongsTo(User::class);
}

En migración:

$table->foreignId('user_id')->constrained()->cascadeOnDelete();

En store:

Task::create([
    ...$request->validated(),
    'user_id' => auth()->id(),
]);

En index:

$tasks = Task::where('user_id', auth()->id())->get();
🚀 DONDE ESTÁS AHORA

Has pasado de:
👉 “tutorial básico”
a
👉 “backend real con lógica profesional”

🧭
