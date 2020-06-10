const unleash = require('unleash-server');
const sharedSecret = '12312Random';

unleash
  .start({
    databaseUrl: 'postgres://postgres:password@localhost:5432/postgres',
    port: 4242,
    preRouterHook: app => {
      app.use('/api/client', (req, res, next) => {                
        console.log(req.headers);
        if (req.header('authorization') !== sharedSecret) {
          res.sendStatus(401);
        } else {
          next();
        }
      });
    },
  })
  .then(unleash => {
    console.log(
      `Unleash started on http://localhost:${unleash.app.get('port')}`,
    );
  });