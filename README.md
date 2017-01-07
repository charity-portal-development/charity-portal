# charity-portal

## Overview

The purpose of this project is to create a website that allows people to post articles about what they can freely give to others and what they are in need of.

Two types of articles can be submitted:
 - something is available for free,
 - there's need for something.
 
The website ought to assist people who can give something and those in need to find each other effectively.

## Guidelines, principles

### Usability

- **Users must be able to post and search articles easily**. Posting an article should not require special technical acquaintance with web technologies, any related industry standard processes, etc. An average home computer or mobile phone user needs to feel that the site is easy to use: articles can be posted and searched very quickly.

### Maintainability, extensibility

- **The website needs to be easily deployable, but extensible.** It needs to be infrastructure-agnostic to the maximum possible extent so that it can be deployed in any environments and using any technologies which provide sufficient resources for the expected load. It should not rely on concrete database solutions or IaaS/PaaS/etc. providers, but it has to be extensible so that custom integrations for any technologies can be implemented.

### Architecture

- **Application servers need to be stateless.** This is to avoid scabability problems and data loss.
- **The use of polyglot persistence is mandatory.** The service layer must depend on abstract data persistence classes/interfaces. Concrete (i.e. technology-specific) data persistence classes need to be packaged into separate modules than the core business logic.

### Development

- **One should be able to start up a demo of the application in a matter of minutes.** Someone who just downloaded the source code of the project needs to be able to compile and start up the website in a matter of few minutes. The default, out of the box configuration (which doesn't need to fit for production use at all, obviously) needs to be able to start up on an single desktop PC or notebook with all the features available for trial.
