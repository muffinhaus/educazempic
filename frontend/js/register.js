document
  .getElementById('registerForm')
  .addEventListener('submit', async (e) => {
    e.preventDefault();
    const newUsername = document.getElementById('newUsername').value;
    const newPass = document.getElementById('newPass').value;
    const messageEl = document.getElementById('message');

    try {
      const res = await fetch('http:/127.0.0.1/auth/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ newUsername, newPass }),
      });

      const data = await res.json();
      if (!res.ok) {
        messageEl.textContent = data.error;
        messageEl.className = 'error';
        return;
      }
      messageEl.textContent = `✅ ${data.username} registrado!`;
      messageEl.className = 'success';
      document.getElementById('registerForm').reset();
    } catch (err) {
      messageEl.textContent = 'Error conexión';
      messageEl.className = 'error';
    }
  });
