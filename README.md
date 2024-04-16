AGENDA DE CONTACTOS EN ANDROID STUDIO


1.- Crear un nuevo proyecto en Android Studio
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/9c25bf6f-df85-4384-bd10-97277eadef32)






2.- Seleccionamos la plantilla Empty Views Activity
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/97ecf890-bcf2-4748-b951-ae2c6f4906a0)






3.- Una vez creado el proyecto procederemos a crear la parte visual o de diseño.
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/42864991-ec70-476e-af57-fbcb2648f0ee)







4.- Creada la parte visual procedemos a ir a la pestaña de MainActivity para generar el código.
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/da195a7d-4e34-47dc-a6ef-3a24c04487f3)






5.- Instanciamos los objetos
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/8c7317f9-413d-4707-bd71-a071813754ad)






6.- Generamos un método que toma una cadena JSON de las preferencias de la aplicación, la convierte en una lista de mapas, y devuelve esa lista.
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/1911ad47-713a-4b52-9b2f-3e07b6307c82)







7.- Generamos este método que toma una lista de contactos en forma de mapas, la convierte a formato JSON utilizando Gson, y luego la guarda en las preferencias compartidas de la aplicación con la clave "lista_contactos".
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/38448574-d340-4436-9c00-d3ee9cfb14bf)






8.- Creamos un método para el botono guardar en donde se guardará todos los datos que el usuario ingrese para el respectivo contacto ingresado.
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/c7cfc0f7-cebc-401e-b784-161c304ec0db)







9.- Después creamos un método para el botón Buscar el cual se encargará de ayudar al usuario a cargar los datos de un contacto guardado.
![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/ebda5c00-8c85-4e10-8c8a-57f7543d091d)







10.- Y por último ejecutamos nuestro emulador para verificar su funcionalidad.


Ingresamos un contacto y guardamos:



![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/d4addb1c-cd61-488d-b531-cb4c0c37f4fd)

 





Buscamos los contactos: 




![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/ab19e3e5-13c5-4b15-a448-feffb58bc2c3)




![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/d0c1474a-0c99-42ce-b7ce-6918444e0b20)





![image](https://github.com/TheoC219/AgendaContactos/assets/136407563/d54ee2a9-7a34-4b06-84f6-fe7c49a8aba1)





Como se puede observar se ha realizado una agenda de contactos, en donde el usuario ingresa los datos de cada contacto y luego puede buscar mediante el nombre completo o solo un nombre los datos del contacto que desee.


