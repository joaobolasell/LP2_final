package main;

import dados.DadosBd;
import telas.TelaColaboradores;
import telas.TelaRegistros;
import telas.TelaSalas;

public class TesteFinal {

    public static void main(String[] args) {

        /* CRIA DADOS SIMULANDO BD */
        DadosBd dadosBd = new DadosBd();

        /* CRIA TELAREGISTROS  */
        TelaRegistros telaRegistros = new TelaRegistros();

        /* CRIA TELACOLABORADORES */
        TelaColaboradores telaColaboradores = new TelaColaboradores();

        /* CRIA TELA SALAS*/
        TelaSalas telaSalas = new TelaSalas();

        /* IMPRIME REGISTROS SEPARADOS POR BLOCO */
        //telaRegistros.mostraRegistrosSeparado(dadosBd.registrosBD);

        /* IMPRIME REGISTROS EM LINHA */
       //telaRegistros.mostrarRegistrosLinha(dadosBd.registrosBD);

        /* CRIA REGISTRO VIA TELAREGISTROS, PEGANDO DADOS DO TECLADO E ADICIONANDO NO BD */
        /* efetuarRegistro MOSTRA TODAS SALAS, APÓS ESCOLHA TESTA E RETORNA SE TEM ACESSO OU NÃO */
        //telaRegistros.efetuarRegistro(dadosBd.colaboradoresBD, dadosBd.salasBD);
        System.out.println("_____________________-------------ESPACO-------------________________________");
        /* IMPRIME PRA CONFIRMAR SE ADICIONOU NO BD */
        //telaRegistros.mostrarRegistrosLinha(dadosBd.registrosBD);

        /* CRIA REGISTRO VIA TELAREGISTROS, PEGANDO DADOS DO TECLADO E ADICIONANDO NO BD */
        /* efetuarRegistroSalasLiberadas MOSTRA APENAS SALAS LIBERADAS PARA O USUARIO */
        //telaRegistros.efetuarRegistroSalasLiberadas(dadosBd.colaboradoresBD, dadosBd.salasBD);
        System.out.println("_____________________-------------ESPACO-------------________________________");
        /* IMPRIME PRA CONFIRMAR SE ADICIONOU NO BD */
        //telaRegistros.mostrarRegistrosLinha(dadosBd.registrosBD);


        /* IMPRIME COLABORADORES */
        //telaColaboradores.mostrarColaboradores(dadosBd.colaboradoresBD);
        System.out.println("_____________________-------------ESPACO-------------________________________");

        /* IMPRIME COLABORADORES+SALAS LIBERADAS */
        // telaColaboradores.mostrarColaboradoresSala(dadosBd.colaboradoresBD, dadosBd.salasBD);
        System.out.println("_____________________-------------ESPACO-------------________________________");

        /* IMPRIME RELATORIO COMPLETO DE COLABORADOR COM SALAS LIBERADAS+REGISTROS DO COLABORADOR */
        //telaColaboradores.mostrarTudoColaborador(dadosBd.colaboradoresBD, dadosBd.salasBD, dadosBd.getRegistrosBD());

        /* IMPRIME SALAS */
        //telaSalas.mostrarSalas(dadosBd.salasBD);
        /* IMPRIME SALAS E COLABORADORES LIBERADOS NA SALA*/
        //telaSalas.mostrarSalasColaboradores(dadosBd.salasBD);
        /* IMPRIME SALAS COLABORADORES E REGISTROS NA SALA */
        //telaSalas.mostrarSalasColaboradoresRegistros(dadosBd.salasBD);



    }


}
