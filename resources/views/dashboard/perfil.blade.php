@extends('layouts.app')

@section('title', 'Perfil')

@section('content')
<h1>Bienvenido {{ Auth::user()->name }}</h1>
<p>Este contenido solo lo pueden ver usuarios logueados.</p>

<div id="react-root"></div> {{-- Aquí montaremos React --}}
@endsection