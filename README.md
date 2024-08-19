
# lib-mart-mapper
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)  ![Static Badge](https://img.shields.io/badge/autor-Anderson_Martins-blue)
![Static Badge](https://img.shields.io/badge/framework-spring-green)


        mart-mapper é uma biblioteca que foi criada para facilitar a instancias de outras classes como de classes
        DTO para entidades e vice versa.


## Documentation


#### Gerenciamento de Transações:
Instancia uma nova classe com os valores da classe anterior 

## Installation

Pré-requisitos:

Acrescente a dependencia abaixo em seu pom 

```bash
<dependency>
  <groupId>mart-mapper</groupId>
  <artifactId>dto-mapper</artifactId>
  <version>0.0.1</version>
</dependency>
```
Instale no maven com o comando abaixo

```
mvn install
```

## Usage/Examples

```javascript
        ClasseA classeA = new ClasseA();
        
        ClassB classeDTO = mappers.mapper(classeA, ClassB.class);
        
       classeDTO.atributo1 == classeA.atributo1(true)
```

## Authors

- [@andersonM](https://github.com/AndersonMartinsDev)


## Roadmap

- Anotações para uso de atributos customizados

- Mapear mais cenários de testes unitários para garantir o funcionamento 

- Poder converter Map ou HashMap em uma Classe instanciada
