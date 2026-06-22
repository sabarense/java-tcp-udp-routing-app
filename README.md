# Passo a Passo: Trabalho Prático I - Roteamento

## Fase 1: Infraestrutura de Rede (Cisco Packet Tracer)

Nesta etapa, montaremos a topologia de rede exigida no projeto do Cisco Packet Tracer. Utilizaremos a adaptação permitida de dois roteadores, mantendo as três faixas de IP estipuladas para a configuração.

### 1.1. Topologia e Endereçamento

Monte a topologia conectando os dois computadores conforme a tabela abaixo:

* **PC1:** Conectado à rede do R1. Endereço na faixa 192.168.0.0/16.
* **R1 (Gateway PC1 e Roteador de Borda):** Conectado ao PC1 e ao R3. Utiliza as faixas 192.168.0.0/16 38] e 172.16.0.0/12.
* **R3 (Gateway PC2 e Roteador de Borda):** Conectado ao R1 e ao PC2. Utiliza as faixas 172.16.0.0/12 39] e 10.0.0.0/8.
* **PC2:** Conectado à rede do R3. Endereço na faixa 10.0.0.0/8.

### 1.2. Roteamento Estático e Redirecionamento (Port Forwarding)

* Configure as rotas estáticas em R1 e R3 para que as redes das extremidades se enxerguem.
* A aplicação servidor rodará no PC2.
* **Em R1:** Redirecione todos os pacotes destinados à porta da aplicação para o IP da interface conectada de R3.
* **Em R3:** Redirecione todos os pacotes destinados à porta da aplicação para o endereço IP do PC2 (servidor).
* **Ação necessária:** Tire prints da topologia montada e das principais telas de configuração dos roteadores.

---

## Fase 2: Desenvolvimento da Aplicação (Java)

A aplicação consiste em um sistema em Java, contendo interface gráfica Java Swing para o cliente, uso de protocolos TCP e UDP e programação com multithreading.

* **Código do Servidor (`Servidor.java`):** Deve ser executado no PC2. Utilize o código Java gerado anteriormente e compile-o nesta máquina. Ao rodar, ele iniciará as *threads* necessárias para escutar e processar as requisições TCP e UDP simultaneamente nas portas definidas.
* **Código do Cliente (`Cliente.java`):** Deve ser executado no PC1. Compile e execute o código da interface Java Swing. Utilize os botões da interface para acionar as *threads* responsáveis por enviar as mensagens via TCP e UDP sem congelar a tela principal.
* **Ação necessária:** Tire prints da interface da aplicação em funcionamento para adicionar ao relatório.

---

## Fase 3: Testes Práticos e Captura (Wireshark)

Para testar a aplicação de forma realista e capturar os pacotes para a avaliação57], utilizaremos o Radmin VPN para conectar duas máquinas físicas.

* **Passo 1:** Conecte o PC1 (seu computador) e o PC2 (computador de um colega) na rede do Radmin VPN. Anote o IP fornecido pela VPN para o PC2.
* **Passo 2:** No PC2, execute a aplicação servidor.
* **Passo 3:** Abra o Wireshark no PC1, selecione a interface virtual do Radmin VPN e inicie a captura. Filtre especificamente pelas portas TCP e UDP usadas na aplicação.
* **Passo 4:** No PC1, execute a aplicação cliente. Insira o IP do PC2 na interface e envie mensagens utilizando as funcionalidades TCP e UDP.
* **Passo 5:** Pare a captura no Wireshark.
* **Ação necessária:** Tire um print da tela da avaliação no Wireshark mostrando o tráfego TCP (handshake) e os datagramas UDP capturados.

---

## Fase 4: Estruturação do Relatório Final

O trabalho deve ser enviado em formato PDF via Canvas. O relatório deve ser objetivo, claro e direto. Estruture o documento da seguinte maneira:

* **Capa/Cabeçalho:** Nome, Matrícula e Disciplina (Redes de Computadores I).
* **Objetivo:** Breve resumo sobre o desenvolvimento da aplicação, uso do multithreading e protocolos TCP e UDP.
* **Metodologia e Topologia:** Explicação sobre a adaptação para dois roteadores e os prints do Cisco Packet Tracer com as telas de configuração dos roteadores.
* **Desenvolvimento de Software:** Inserir o print da interface Java Swing e explicar a implementação do código Java.
* **Avaliação de Tráfego:** Inserir os prints da avaliação no Wireshark.
* **Conclusão:** Principais desafios encontrados e como foram solucionados.
