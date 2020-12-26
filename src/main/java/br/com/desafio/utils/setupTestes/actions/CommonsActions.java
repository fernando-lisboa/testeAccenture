package br.com.desafio.utils.setupTestes.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebDriver;

import br.com.desafio.utils.setupTestes.rest.IPostActions;

public class CommonsActions {
	private static Token token;
	IPostActions contratar = new IPostActions();
	TokenActions tokenActions = new TokenActions();
	WebDriver webdriver;

	public ResultSet consultaBanco(Connection conexao, String query) throws Exception {
		PreparedStatement comando = conexao.prepareStatement(query);
		ResultSet executeQuery = comando.executeQuery();
		return executeQuery;
	}

	public void tearDown() throws Exception {
		System.out.println("Limpando Banco de dados para inicio dos testes...");
		System.out.println("Banco de dados limpo para testes...");
	}

	public void insertMassaCancelamentoEContratacaoWeb() throws Exception {
		System.out.println("Inserindo massa de testes no Banco de dados...");
		// consultaBancoHmlPoint(ConnPpoint.getConexao(),
		// queryIndicadores.retornaInsertTransacoes().toString());
		System.out.println("Banco populado para inicio dos testes...");
	}

	// retorna um calendar com a hora do sistema
	public String horaArv() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH");
		String horaFormatada = formatterHora.format(agora);
		return horaFormatada;
	}

	public void validaData() {
		Calendar user = new GregorianCalendar(2014, Calendar.OCTOBER, 04);// informando
		Calendar now = new GregorianCalendar();
		user.before(now);
	}

	public String dataMaisTrinta() {
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		data.add(Calendar.MONTH, +1);
		String dataFormatada = new SimpleDateFormat("dd/MM/yy").format(data.getTime());
		return dataFormatada;
	}

	public String dataAtual() {
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		// data.add(Calendar.MONTH, +1);
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		return dataFormatada;
	}

	public String dataRecebiveis(int index) {
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		data.add(Calendar.DAY_OF_MONTH, +index - 1);
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		return dataFormatada;
	}

	public Token gerarToken() {
		if (token == null) {
			tokenActions.setToken("teste");
			token = tokenActions.getToken();
			System.out.println("TOKEN: " + token.getBodyRequest());
		}
		return token;
	}

	public static Token getToken() {
		if (token == null) {
			TokenActions ta = new TokenActions();
			ta.setToken("teste");
			token = ta.getToken();
		}
		return token;
	}

	public void prepararBancoParaInicioDosTestesBloqueio() throws Exception {
		tearDown();
	}

	public void prepararBancoParaInicioDosTestesContratacao() throws Exception {
		tearDown();
		insertMassaCancelamentoEContratacaoWeb();
	}

	public void prepararBancoParaInicioDosExtrato() throws Exception {
		tearDown();
		insertMassaCancelamentoEContratacaoWeb();
	}

}
