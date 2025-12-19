document
  .getElementById('loginForm')
  .addEventListener('submit', async function (e) {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const pass = document.getElementById('pass').value;

    try {
      const res = await fetch('http://127.0.0.1:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, pass }),
      });

      if (!res.ok) {
        const err = await res.json();
        document.getElementById('error').innerText =
          err.error || 'Error de login';
        return;
      }

      const data = await res.json(); // { username, role }

      if (data.role === 'ROLE_ADMIN') {
        window.location.href = 'admin.html';
      } else if (data.role === 'ROLE_STUDENT') {
        window.location.href = 'student.html';
      } else {
        document.getElementById('error').innerText = 'Rol no reconocido';
      }
    } catch (err) {
      console.error('Error de red:', err);
      document.getElementById('error').innerText =
        'Error de conexión al servidor';
    }
  });
