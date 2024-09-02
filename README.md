# Event_Journal
Programmation Orienté Objet – JAVA 
[Uploading exaPOO2324SS.pdf…]()

1 Développement (partie 1)
Sur base de l’exercice étudié en classe Journal_Event, veuillez implémenter les classes représentées dans le diagramme UML ci-dessous.
Pour toutes les classes de ce problème, veuillez générer les accesseurs utiles ainsi que, au minimum, un constructeur pourvu de tous les paramètres. S’il est possible de définir un constructeur par défaut, déclarez-le aussi.
interface
1.1 Énoncé 1 (Interface)
Écrivez la définition de l’interface Applicable qui annonce le service public suivant : • boolean apply(Guest g)
1.2 Énoncé 2 (Classe – héritage)
Définissez l’énumération Topic qui décrit les sujets suivants : ENERGY, ENVIRONMENT et IT.
Définissez ou modifiez, tel que représenté dans le diagramme, la classe Guest. Un objet de type Guest se définit par les champs suivants :
- firstname (le prénom de l’invité : « Bob »),
- lastname (le nom : « Sull »),
- topics (les thèmes abordés : « IT, ENVIRONMENT »).
Définissez ou modifiez, tel que représenté dans le diagramme, la classe Conference. Un objet de type Conference se définit par les champs suivants :
- topic (le thème de la conférence : « IT »),
- price (le prix : 50.00 €) et
- guests (les invités à la conférence : « Bob, Lydia, Max, Fatou »).
 Journal
 - events
 + toString()
  Evenement
 - texte : String
- dateEvent : DateTime
 RuntimeException
  MissingTopicException
 Guest
 - firstname : String - lastname : String - topics
   Applicable
 + apply(Guest) : boolean
  Conference
 - topic : Topic - price : double - guests
 + toString()
   «enumeration» Topic
 ENERGY ENVIRONMENT IT
     

Définissez ou modifiez, tel que représenté dans le diagramme, la classe Evenement. Un objet de type Evenement se définit par les champs suivants :
- texte (le titre de l’événement : « Conférence low emission IT ») et
- dateEvent (la date et l’heure : « 02/09/2024 à 18:00 »).
Écrivez la classe Exception : MissingTopicException de type RuntimeException.
2 Tests unitaires (énoncé 3)
Ecrivez les tests unitaires (plusieurs si nécessaire) pour la classe Conference, telle que représentée dans le diagramme : elle implémente l’interface Applicable.
1) Le constructeur :
- Un objet de type Conference hérite de la classe Evenement et se définit par les champs texte, dateEvent, topic, price et guests qui est une simple liste d’objets Guest. Par défaut, la conférence est gratuite. Une conférence peut ne pas avoir de thème (topic).
         new Conference("Conférence low emission IT","2024-09-
         02T18:00",Topic.IT,30d);
         new Conference("Bavardages citoyens","2024-09-06T20:00");
- Elle implémente l’interface Applicable ;
2) La méthode boolean apply(Guest g)
Elle doit ajouter l’invité donné en paramètre à la liste des invités de la conférence si et seulement si l’invité possède parmi ses thèmes (topics) le thème de la conférence (topic), sinon il faudra lever l’exception MissingTopicException. Aucune exception levée si la conférence n’a pas de thème.
3) La méthode toString()
Elle doit afficher la conférence, sa date et heure, son prix, son thème et la liste des invités (prénom puis nom en majuscules).
  3
1) 2)
   Bavardages citoyens – 06/09/2024 à 20:00 – Gratuit / Thème libre
- Bob SULL
- Lydia JENKINS Développement (partie 2)
3.1 Énoncé 4 (Implémentation et documentation)
Ecrivez la documentation JavaDoc complète de la classe Conference.
Implémentez les méthodes de la classe Conference: constructeurs, accesseurs, toString et apply (voir plus haut pour les détails).
 
Nom : ........................................................ Prénom : ..................................................................
3.2 Énoncé 5 (Sérialisation)
Définissez des méthodes permettant de sérialiser et désérialiser un objet Conference dans un fichier XML : loadConfFromFile(String filename) et saveConfToFile(Conference conf, String filename).
Veillez à définir les attributs, les alias de classes et d’attributs, ainsi que les collections implicites. Enfin, ajoutez toutes autres spécifications permettant d’obtenir le résultat ci-dessous :
      <Conf title="Conférence low emission IT" date="2024-09-02TT18:00:00"
price="30.0">
            <topic>IT</topic>
            <guest>
                  <firstname>Bob</firstname>
                  <lastname>Sull</lastname>
                  <skill>IT</skill>
                  <skill>ENVIRONMENT</skill>
            </guest>
      </Conf>
