export const navigation = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: 'icon-speedometer',
    badge: {
      variant: 'info'
    }
  },
  {
    title: true,
    name: 'Administracin de Usuarios'
  },
  {
    name: 'Usuarios',
    url: '/changespassword',
    icon: 'icon-puzzle',
    children: [
      {
        name: 'Cambiar contrase\u00F1a',
        url: '/users/changespassword',
        icon: 'icon-puzzle'
      }
    ]
  }
];
