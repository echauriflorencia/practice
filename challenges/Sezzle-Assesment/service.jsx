const express = require('express');
const app = express();
const { getUsers } = require('./db.js');

app.get('/users', async (req, res) => {
  try {
    const { name } = req.query;

    const users = await getUsers(); // usar await por seguridad

    if (name !== undefined) {
      const filteredUsers = users.filter(user => user.name === name);
      return res.status(200).json(filteredUsers);
    }

    return res.status(200).json(users);

  } catch (err) {
    return res.sendStatus(500);
  }
});

module.exports = app;