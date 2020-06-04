# Changelog
## [2.0.0]
### Release
- Migrated the old J2EE application to Spring boot self executable jar.
- Introduced education level field to Student object.
- Added Junit test cases to check the logic of education level for various students based on the below criteria.

    >logic:
    
        if(age<13)
          students are not allowed to enter into the system
        else if(age >12 && age <=16)
         set the education level to Elementary
        else if(age >16 && age <=22>)
         set the education level to Secondary
        else
         set the education level to Higher
      
    

- Added validations to validate the input form data.
- Added sorting to Student id,name,age and education level.
- Added h2 database as persistence database to the application.

## [1.1.0]
### Feature
- Added age field to student object.
- replaced h:dataTable with rich:dataTable and added sorted technique to both name and age.
 
## [1.0.0]
### Features
- Initial commit from codeproject.com