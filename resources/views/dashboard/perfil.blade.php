@extends('layouts.app')

@section('title', 'Perfil')

@section('content')
<h1>Bienvenido {{ Auth::user()->name }}</h1>
<p>Este contenido solo lo pueden ver usuarios logueados.</p>

<a href="{{route('tasks.index')}}">Listados</a>
<a href="{{route('tasks.create')}}">Create</a>





<div id="react-root"></div> {{-- Aquí montaremos React --}}
@endsection