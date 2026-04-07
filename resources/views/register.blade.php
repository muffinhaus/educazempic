{{-- resources/views/login.blade.php --}}
@extends('layouts.app')

@section('title', 'Login')

@section('content')

   

<form  method="POST" action="/register" class="form-login">
        @csrf
    <h1>Unete</h1>

    <div class="mb-3">
    <label for="exampleInputName1" class="form-label">Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputName1" aria-describedby="nameHelp">
  </div>

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
    <input type="password" name="password_confirmation" class="form-control" id="exampleInputPassword1">

  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
   @if($errors->any())
        <div style="color:red;">
            {{ $errors->first() }}
        </div>
    @endif
</form>
@endsection
