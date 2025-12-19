const form = document.getElementById('form-usuario');

form.addEventListener('submit', async (e) => {
  e.preventDefault();

  const usuario = {
    username: document.getElementById('username').value,
    email: document.getElementById('email').value,
    pass: document.getElementById('password').value,
    role: document.getElementById('role').value,
  };

  try {
    const res = await fetch('http://localhost:8080/usuario/registrar', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(usuario),
    });

    if (res.ok) {
      alert('Usuario registrado exitosamente');
      form.reset();
    } else {
      alert('Error al registrar usuario');
    }
  } catch (error) {
    console.error('Error registrando usuario:', error);
  }
});
