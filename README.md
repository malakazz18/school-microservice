 🏫 School Microservice
##  Objectif

Conception et développement d'un **microservice REST** en utilisant **Spring Boot 4.0.6** et **Spring Data JPA**, avec une base de données **PostgreSQL**.


##  Membres du groupe : Azzouz Malek G1 et Lahbib Malek G2 equipe 11 

##  Structure du projet

```
school-microservice/
├── src/
│   └── main/
│       ├── java/
│       │   └── edu/isgb/school/
│       │       ├── entities/          # Entités JPA
│       │       │   ├── School.java
│       │       │   ├── Department.java
│       │       │   ├── Student.java
│       │       │   ├── Address.java
│       │       │   ├── Instructor.java
│       │       │   └── Course.java
│       │       ├── repositories/      # Interfaces Spring Data JPA
│       │       │   ├── SchoolRepository.java
│       │       │   ├── StudentRepository.java
│       │       │   ├── InstructorRepository.java
│       │       │   ├── CourseRepository.java
│       │       │   └── DepartmentRepository.java
│       │       ├── services/          # Logique métier
│       │       │   └── SchoolService.java
│       │       └── Controller/              # Contrôleur REST
│       │           └── TestSchoolController.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

---

##  Modèle de données

Le projet implémente le diagramme de classes complet avec les règles de navigabilité suivantes :

| Relation | Type de mapping |
|----------|----------------|
| `Student → Address` | Unidirectionnel `@OneToOne` |
| `School ↔ Department` | Bidirectionnel `@OneToMany / @ManyToOne` |
| `School ↔ Student` | Bidirectionnel `@OneToMany / @ManyToOne` |
| `School ↔ Instructor` | Bidirectionnel `@OneToMany / @ManyToOne` |
| `Instructor ↔ Course` | Bidirectionnel `@ManyToMany` |

---

## ⚙️ Configuration

### Prérequis

- Java 21
- PostgreSQL installé et démarré
- IntelliJ IDEA (ou autre IDE)

### Base de données

Créer la base de données PostgreSQL :

```sql
CREATE DATABASE schooldb;
```

### `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/schooldb
spring.datasource.username=postgres
spring.datasource.password=votre_mot_de_passe
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Lancement du projet

1. Cloner le dépôt :
```bash
git clone https://github.com/votre-repo/school-microservice.git
```

2. Ouvrir le projet dans IntelliJ IDEA

3. Recharger Maven : clic droit sur `pom.xml` → **Maven** → **Reload Project**

4. Lancer la classe principale `SchoolMicroserviceApplication.java`

---

## 🔗 Endpoints REST

| Méthode | URL | Description |
|---------|-----|-------------|
| `POST` | `/api/schools` | Créer une nouvelle école |
| `GET` | `/api/schools/{id}` | Récupérer une école par id |
| `POST` | `/api/students?schoolId=1` | Créer un étudiant avec adresse |
| `GET` | `/api/students` | Lister tous les étudiants |
| `POST` | `/api/instructors` | Créer un instructeur avec ses cours |
| `GET` | `/api/instructors?name=...` | Chercher un instructeur par nom |
| `GET` | `/api/instructors/{id}` | Récupérer un instructeur par id |
| `GET` | `/api/instructors/{id}/courses` | Lister les cours d'un instructeur |
| `POST` | `/api/instructors/{id}/courses` | Ajouter un cours à un instructeur |
| `GET` | `/api/courses/{id}` | Récupérer un cours par id |

---

## Tests des endpoints

Les endpoints ont été testés avec **Postman**.

### Exemple — Créer une école

**POST** `http://localhost:8080/api/schools`

```json
{
  "name": "ISG Bizerte",
  "phone": 72123456
}
```

### Exemple — Créer un étudiant

**POST** `http://localhost:8080/api/students?schoolId=1`

```json
{
  "name": "Ahmed Ben Ali",
  "birthDate": "2002-05-15",
  "address": {
    "street": "Rue de la République",
    "city": "Bizerte",
    "postalCode": "7000"
  }
}

<img width="1072" height="928" alt="image" src="https://github.com/user-attachments/assets/cbb745e0-a5d9-4f86-a0ea-0b7c36ccf8f6" />

```

### Exemple — Créer un instructeur avec cours

**POST** `http://localhost:8080/api/instructors`

```json
{
  "name": "Dr. Ben Salah",
  "courses": [
    { "name": "Java Avancée" },
    { "name": "Architectures Logicielles" }
  ]
}
```

---

## 📐 Architecture en couches

```
Controller  →  Service  →  Repository  →  Base de données
   (REST)     (Métier)    (Spring Data)     (PostgreSQL)
```


Le compte rendu du projet est disponible dans ce fichier :

