# Notifiction Service
This repository is part of the **Inkwell Book Store**, built as a distributed system project. For more information about the system check the [main page](https://github.com/inkwell-store).

## About
This project contains a service that sends notifications (emails) in response to various events in the system.

To send an email it is necessary to setup a SMTP provider, which involves the use of sensitive information, such a keys. Because this repository is public publishing this kind of information is not recommended. 

One possible solution to this problem is to generate the email data and, instead of send it via an SMTP provider, write the email to a file inside the host's OS. This strategy allows anyone that builts the system in their machien to access relevant information on these emails, while it allows me to use a smtp provider.


