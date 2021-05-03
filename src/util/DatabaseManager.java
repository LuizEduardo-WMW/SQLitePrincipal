package util;

import java.sql.SQLException;

import totalcross.db.sqlite.SQLiteUtil;
import totalcross.sql.Connection;
import totalcross.sql.Statement;
import totalcross.sys.Settings;
import totalcross.sys.Vm;

public class DatabaseManager {

	
	public static SQLiteUtil sqliteUtil;
	
	static {
		try {
			sqliteUtil = new SQLiteUtil(Settings.appPath, "app.db");
		} catch (SQLException e) {
			Vm.debug(e.getMessage());
		}
	}
	
//	criando um m�todo est�tico que ir� nos retornar uma conex�o a partir do sqliteUtil
	public static Connection getConnection() throws SQLException {
//		O m�todo con() ir� retornar apenas uma conex�o por inst�ncia do SQLiteUtil, ent�o, se a conex�o j� existir, a mesma ser� retornada, se ela n�o existir uma nova ser� criada, e ser� usada nas pr�ximas intera��es.		
		return sqliteUtil.con();
	}
	
// 	Criando as tabelas do banco de dados
	public static void loadTabelas() throws SQLException {
		Statement st = getConnection().createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS SORVETES (CODIGO NUMERIC NOT NULL UNIQUE, SABOR VARCHAR UNIQUE, VALORUNIDADE NUMERIC, ESTOQUEATIVO NUMERIC, PRIMARY KEY(CODIGO))");
		st.execute("CREATE TABLE IF NOT EXISTS VENDAS (CODIGO NUMERIC NOT NULL UNIQUE, SABOR VARCHAR UNIQUE, VALORUNIDADE NUMERIC, VALORVENDA NUMERIC, VALORTOTAL NUMERIC, ESTOQUEVENDA NUMERIC, ESTOQUEATIVO NUMERIC, ESTOQUEVENDIDO NUMERIC, PRIMARY KEY(CODIGO))");
		//st.execute("DROP TABLE SORVETES");
		//st.execute("DROP TABLE VENDAS");
//      Lembre-se, que sempre ao t�rmino da utiliza��o de um Statement ele deve ser fechado, atrav�s do m�todo close(), para que sejam liberados os recursos por ele alocados.		
		st.close();
	}

}
