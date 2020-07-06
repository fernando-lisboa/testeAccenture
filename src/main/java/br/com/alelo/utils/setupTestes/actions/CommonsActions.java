package br.com.alelo.utils.setupTestes.actions;

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

import br.com.alelo.integrations.db.ConnPpoint;
import br.com.alelo.integrations.db.ConnSit;
import br.com.alelo.integrations.db.ConnUsadq;
import br.com.alelo.integrations.db.ConnUsodsadq;
import br.com.alelo.utils.setupTestes.query.LimparPID;
import br.com.alelo.utils.setupTestes.query.QueryPreparaBancoArv;
import br.com.alelo.utils.setupTestes.query.QueryPreparaBancoIndicadoresPainel;
import br.com.alelo.utils.setupTestes.query.QueryPreparaTesteExtrato;
import br.com.alelo.utils.setupTestes.query.QueryPreparaTestesUpload;
import br.com.alelo.utils.setupTestes.query.QueryUploadNovosPlanos;
import br.com.alelo.utils.setupTestes.rest.IPostActions;

public class CommonsActions {
	private static Token token;
	IPostActions contratar = new IPostActions();
	TokenActions tokenActions = new TokenActions();
	QueryPreparaBancoIndicadoresPainel queryIndicadores = new QueryPreparaBancoIndicadoresPainel();
	QueryPreparaTestesUpload upload = new QueryPreparaTestesUpload();
	QueryUploadNovosPlanos qPlanos = new QueryUploadNovosPlanos();
	QueryPreparaBancoArv arv = new QueryPreparaBancoArv();
	WebDriver webdriver;
	QueryPreparaTesteExtrato extrato = new QueryPreparaTesteExtrato();
	LimparPID pid = new LimparPID();

	public void preparaBanco(Connection conexao, String query, String idPersonUnit, String status) throws Exception {

		if (status.equals("EL")) {
			PreparedStatement comando;
			comando = conexao.prepareStatement(query);
			comando.executeQuery();
		} else if (status.equals("CO")) {
			PreparedStatement comando;
			comando = conexao.prepareStatement(query);
			comando.executeQuery();

			contratar.postComParametroNaUrl(idPersonUnit, status);
		} else if (status.equals("CG")) {
			PreparedStatement comando;
			comando = conexao.prepareStatement(query);
			comando.executeQuery();

			contratar.postComParametroNaUrl(idPersonUnit, "CO");
		} else {
			PreparedStatement comando;
			comando = conexao.prepareStatement(query);
			comando.executeQuery();
			contratar.postComParametroNaUrl(idPersonUnit, "CO");
			contratar.postComParametroNaUrl(idPersonUnit, status);
		}
	}

	public void preparaBancoSitCancelamento(Connection conexao, String query, String idPersonUnit, String status)
			throws Exception {
		PreparedStatement comando;
		comando = conexao.prepareStatement(query);
		comando.executeQuery();
		contratar.postComParametroNaUrl(idPersonUnit, "CO");
	}

	public void preparaBancoSitContrataFree(Connection conexao, String query, String idPersonUnit,
			int codigoRetornoEsperado, String status) throws Exception {
		PreparedStatement comando;
		comando = conexao.prepareStatement(query);
		comando.executeQuery();
	}

	public void upDateDataFim(Connection conexao, String query) throws Exception {
		PreparedStatement comando;
		comando = conexao.prepareStatement(query);
		comando.executeQuery();
	}

	public ResultSet consultaBanco(Connection conexao, String query) throws Exception {
		PreparedStatement comando = conexao.prepareStatement(query);
		ResultSet executeQuery = comando.executeQuery();
		return executeQuery;
	}

	public ResultSet consultaBancoHmlPoint(Connection conexao, String query) throws Exception {
		PreparedStatement comando = conexao.prepareStatement(query);
		ResultSet executeQuery = comando.executeQuery();
		return executeQuery;
	}

	public void consultaBancoBuc(Connection conexao, String query) throws Exception {
		PreparedStatement comando = conexao.prepareStatement(query);
		comando.executeQuery();
		comando.close();
	}

	public void tearDown() throws Exception {
		System.out.println("Limpando Banco de dados para inicio dos testes...");
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaDeleteLocalidade().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaDeleteOferta().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaDeletecontratos().toString());
		System.out.println("Banco de dados limpo para testes...");
	}

	public void tearDowntransactions() throws Exception {
		System.out.println("Limpando Banco de dados de transações...");
		consultaBancoHmlPoint(ConnPpoint.getConexao(), queryIndicadores.retornaDeleteIndicadoresDiario().toString());
		consultaBancoHmlPoint(ConnPpoint.getConexao(), queryIndicadores.retornaDeleteIndicadoresMensal().toString());
		consultaBancoHmlPoint(ConnPpoint.getConexao(), queryIndicadores.retornaDeleteIndicadoresSemanal().toString());
		System.out.println("Banco de dados limpo para testes...");
	}

	public void insertMassaDeTeste() throws Exception {
		System.out.println("Inserindo massa de testes no Banco de dados...");
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertOferta().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertLocalidade().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacao1().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacao2().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacao3().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacao4().toString());
		consultaBancoHmlPoint(ConnPpoint.getConexao(), queryIndicadores.retornaInsertTransacoes().toString());
		System.out.println("Banco populado para inicio dos testes...");
	}

	public void insertMassaCancelamentoEContratacaoWeb() throws Exception {
		System.out.println("Inserindo massa de testes no Banco de dados...");
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertOferta().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertLocalidade().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacao1().toString()); // 28339982000160
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacaoForaPeriodoTestes().toString()); // 41707658000115
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertContratacaoCancelado().toString()); // 11699141000160
		// consultaBancoHmlPoint(ConnPpoint.getConexao(),
		// queryIndicadores.retornaInsertTransacoes().toString());
		System.out.println("Banco populado para inicio dos testes...");
	}

	public void insertMassaDeBloqueio() throws Exception {
		System.out.println("Inserindo massa de testes no Banco de dados...");
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertOferta().toString());
		consultaBanco(ConnUsadq.getConexao(), queryIndicadores.retornaInsertLocalidade().toString());
		consultaBanco(ConnUsadq.getConexao(), upload.retornaInsertBloqueioContratoForaDoTesteGratis().toString());
		consultaBanco(ConnUsadq.getConexao(), upload.retornaInsertBloqueioContratoTestGratis().toString());
		consultaBanco(ConnUsadq.getConexao(), upload.retornaInsertDesbloqueioContratoForaDoTesteGratis().toString());
		consultaBanco(ConnUsadq.getConexao(), upload.retornaInsertDesbloqueioContratoTestGratis().toString());
		System.out.println("Inserido dados para teste de Bloqueio...");
	}

	public void insertMassaExtratoHML() throws Exception {
		System.out.println("Inserindo massa de testes no Banco de dados...");
		deletaMassaExtratoHML();
		Thread.sleep(2000);
		consultaBanco(ConnPpoint.getConexao(), extrato.retornaInsertTabelaTADQ_TRANS().toString());
		consultaBanco(ConnUsodsadq.getConexao(), extrato.retornaInsertTabelaTIND_EC_MES().toString());
		consultaBanco(ConnUsodsadq.getConexao(), extrato.retornaInsertTabelaTIND_EC_TPO_DIA().toString());

		System.out.println("Banco populado para testes EXTRATO...");
	}

	public void deletaMassaExtratoHML() throws Exception {
		System.out.println("Preparando massa de testes no Banco de dados...");
		consultaBanco(ConnPpoint.getConexao(), extrato.retornaDeleteTabelaTADQ_TRANS().toString());
		consultaBanco(ConnUsodsadq.getConexao(), extrato.retornaDeleteTabelaTIND_EC_MES().toString());
		consultaBanco(ConnUsodsadq.getConexao(), extrato.retornaDeleteTabelaTIND_EC_TPO_DIA().toString());

	}

	public void updateParaContratacaoArv() throws Exception {
		System.out.println("Preparando banco de dados para simulação de ARV...");
		String hora = horaArv();

		if (Integer.parseInt(hora) < 14) {
			System.out.println(Integer.parseInt(hora));
			consultaBanco(ConnUsadq.getConexao(), arv.roternaUpdateDataDeProcessmentoPM().toString());

		} else {
			System.out.println(Integer.parseInt(hora));
			consultaBanco(ConnUsadq.getConexao(), arv.roternaUpdateDataDeProcessmentoAM().toString());
		}

		consultaBanco(ConnUsadq.getConexao(), arv.roternaUpdateIdSolicitacao().toString());
		consultaBanco(ConnUsadq.getConexao(), arv.roternaDeletePlanoRecorrente().toString());
		Thread.sleep(2000);

		System.out.println("Banco preparado com sucesso...");
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

	public void limpaPlanos() throws Exception {
		System.out.println("Limpando Banco de dados para inicio dos testes de Upload de Planos...");
		consultaBanco(ConnUsadq.getConexao(), qPlanos.retornaDeleteNovosPlanos().toString());
	}

	public void prepararBancoParaInicioDosTestesBloqueio() throws Exception {
		tearDown();
		tearDowntransactions();
		insertMassaDeBloqueio();
	}

	public void prepararBancoParaInicioDosTestesContratacao() throws Exception {
		tearDown();
		tearDowntransactions();
		insertMassaCancelamentoEContratacaoWeb();
	}

	public void prepararBancoParaInicioDosExtrato() throws Exception {
		tearDown();
		tearDowntransactions();
		insertMassaCancelamentoEContratacaoWeb();
	}

	public void preparaBancoPlanos() throws Exception {

		consultaBanco(ConnUsadq.getConexao(), qPlanos.retornaDeleteContratoSimulaca().toString());
		consultaBanco(ConnUsadq.getConexao(), qPlanos.retornaDeleteOfertaPlanosSimulacao().toString());
		consultaBanco(ConnUsadq.getConexao(), qPlanos.retornaInsertOFertaPlanosSimulacao().toString());

	}

	public void limparPid(String ambiente) throws Exception {

		if (ambiente.equals("hml")) {
			consultaBanco(ConnUsadq.getConexao(), pid.deletaPID().toString());
		} else {
			consultaBanco(ConnSit.getConexao(), pid.deletaPID().toString());
		}

	}

}
