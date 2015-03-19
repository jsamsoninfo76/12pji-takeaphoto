# Introduction #

Connexion client - serveur

La connexion client - serveur se fait via l'objet HTTPClient.
Nous peuplons les différents paramètres a passer au Serveur en HTTPpost en lui associant un couple de paramètre sous la forme : ("login","nomdulogin").

Le serveur quant à lui renvoie au client un tableau en JSON qui peux contenir plusieurs cases :
  * result : TRUE ou FALSE
  * url : list des liens des photos
  * message : renvoie le message d'erreur
  * id : renvoie l'id demandé

# Liens #

  * http://appinventor.blogspot.fr/2011/09/android-mysql-connectivity-via-json.html
  * http://stackoverflow.com/questions/3381523/httpost-in-android
  * http://wiki.frandroid.com/wiki/Requ%C3%AAte_HTTP_POST
  * http://developer.android.com/reference/org/apache/http/client/methods/HttpPost.html