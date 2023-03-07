# api_creacion_usuario_evaluacion_java

-Esta api permite crear usuarios con ciertos campos y una lista de telefonos

Esta implementada con la siguiente caracteristicas 
  -JAVA VERSION 1.8
  -SPRING BOOT 3.0.4
  -REPOSITORIO BASE DE DATOS DE MEMORIA H2
  -CODIGO IMPLEMENTADO EN IDE ECLIPSE
  -PRUEBAS REALIZADAS A TRAVEZ DE POSTMAN CON LA SIGUIENTE URL PRINCIPAL http://localhost:8080/usuarioNew
  -EL METODO DE CREACION DE USUARIO CONTIENE VALIDACION DE EMAIL Y CLAVE BAJO EL CONCEPTO DE EXPRESIONES REGULARES
  -PARA EL CORREO DEBE CONSIDERARSE EL EJEMPLO ALGO@ALGO.CL
  -PARA LA CLAVE SE DEBE CONSIDERAR QUE SEA ENTRE 4 A 8 CARACTERES Y QUE CONTENGA LETRAS MAYUSCULAES Y MINUSCULAS, NUMEROS Y CARACTERES ESPECIALES
  -PARA ACCEDER A LA CONSOLA DE LA BASE DE DATOS UTILIZAR LA SIGUIENTE URL http://localhost:8080/h2-console/  (Se adjunta imagen de referencia)
  -EN LA CONSOLA DE LA BASE DE DATOS SE PUEDE REVISAR LOS DATOS INSERTADOS
  -PARA EL CASO DE EXISTO SE MUESTRAN DATOS DE REFERENCIA DEL USUARIO CREADO Y DEL MISMO MODO PARA LA VALIDACION DE CORREO EXISTENTE, CORREO VALIDO Y CLAVE VALIDA
    
  
  DATOS DE PRUEBA ENVIADOS CON FORMATO JSON
  ----------inicio-------
  {
    "name": "Pedro",  
    "email": "amit@yahoo.co",
    "password": "clAvep*2" ,
    "estado": "true" ,
    "listaTelefonos":
    [
        {
            "phone":"123456",
            "citycode":"1",
            "contrycode":"57"
        },
        {
            "phone":"165554",
            "citycode":"13",
            "contrycode":"537"
        }
    ]
  }
  --------fin-------
