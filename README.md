# Trabalho Final Luiggi Mathew Scortegagna LPOO

Trabalho feito com diagrama de trabalho final de APS.

[Imagem do diagrama clique aqui.](https://github.com/LuiggiMSC/TrabalhoFinal/blob/master/LuiggiMathewScortegagnaClinicaVeterinaria.png)

# DIAGRAMA DE CLASSES: 

Uma classe "Pessoa" é abstrata, possuindo Cliente e Funcionário como filhos.
Dessa maneira, não é criada diretamente, é usada para distribuir atributos em comum (id, nome, cpf) para ambos Cliente e Funcionário.

A classe "Cliente" possui atributos próprios de perfil (tipo) de cliente, utilizado para categorizar cada cliente e facilitar na busca.
Possui também uma lista de Mascotes, para fazer o relacionamento correto, onde um cliente pode ter vários mascotes, mas cada mascote possuir um cliente (dono).
Além disso, pode ter vários agendamentos marcados.

A classe "Funcionário" possui atributos próprios de perfil (tipo) de funcionário, utilizado para categorizar a especialização de um funcionário, ou se é apenas um administrador no sistema.

A classe "Mascote" possui seus atributos básicos, mas também um atributo "dono", que é do tipo "Cliente". Isso é, cada "Mascote" pode possuir UM cliente que é seu dono.

A classe "Servico" possui seus atributos básicos, e uma ligação com "Agendamento" de n, ou seja, uma classe "Servico", como por exemplo banho de pet, pode ser registrada em múltiplos agendamentos.

A classe "Agendamento" possui seus próprios agendamentos, podendo ter um serviço, um cliente, e uma agenda a qual ela pertence.

A classe "Agenda" possui seus próprios atributos, um funcionário que faz parte dessa agenda, e vários agendamentos que esse funcionário pode ter.
