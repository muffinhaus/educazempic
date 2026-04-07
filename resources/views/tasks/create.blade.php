<h1>Crear tarea</h1>

<form action="{{ route('tasks.store') }}" method="POST">
    @csrf

    <input type="text" name="title" placeholder="Título">
    <textarea name="description"></textarea>

    <button type="submit">Guardar</button>
</form>