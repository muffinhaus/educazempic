document
  .getElementById('loginForm')
  .addEventListener('submit', async function (e) {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const pass = document.getElementById('pass').value;

    //hacemos una solicitud al controller de nuestro backend
    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, pass }), // enviar como JSON
      });

      const data = await response.json();
      if (!response.ok) {
        document.getElementById('error').innerText =
          data.error || 'Usuario incorrecto';
        return;
      }

      if (data.role === 'ADMIN') {
        window.location.href = 'admin/dashboard.html';
      } else {
        console.log(data);

        window.location.href = 'student/dashboard.html';
      }
    } catch (err) {
      console.error('Error de red:', err);
      document.getElementById('error').innerText = 'Error de conexión';
    }
  });
