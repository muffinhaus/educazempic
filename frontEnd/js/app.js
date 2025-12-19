async function login() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  try {
    const response = await fetch('http://localhost:8080/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username,
        password,
      }),
    });

    const data = await response.json();

    if (data.error) {
      alert(data.error);
      return;
    }

    // Guardar información del usuario en localStorage para usarla en otros paneles
    localStorage.setItem('user', JSON.stringify(data));

    // Redirigir según rol
    const role = data.role?.replace('ROLE_', '');

    if (role === 'ADMIN') {
      window.location.href = '/admin/admin.html';
    } else if (role === 'STUDENT') {
      window.location.href = '/student/student.html';
    } else {
      alert('Rol desconocido: ' + data.role);
    }
  } catch (error) {
    console.error('Error al iniciar sesión:', error);
    alert('No se pudo conectar al servidor');
  }
}
