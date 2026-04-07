<h1>Lista de tareas</h1>

<a href="{{ route('tasks.create') }}">Nueva tarea</a>

<ul>
@foreach($tasks as $task)
<li>
    {{$task->title}}
    <a href="{{ route('tasks.edit', $task) }}">Editar</a>
    <form action="{{ route('tasks.destroy', $task) }}" method="POST">
            @csrf
            @method('DELETE')
            <button type="submit">Eliminar</button>
        </form>
</li>
@endforeach
</ul>

@if(session('success'))
    <p style="color: green;">
        {{ session('success') }}
    </p>
@endif