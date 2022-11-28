package dao;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDao extends Funcionario {

    public List<Funcionario> listar(String nome) {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {

            Connection con = new ConnectionFactory().getConnection();

            String queryString = "select f.cod_func, f.nome_func, f.sal_func, c.ds_cargos from tbFunc f inner join tbCargos c on (f.cod_cargos = c.cd_cargos) where f.nome_func like '"
                    + nome + "%'";

            PreparedStatement smt = con.prepareStatement(queryString);

            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId(rs.getInt("cod_func"));
                f.setNome(rs.getString("nome_func"));
                f.setSalario(rs.getDouble("sal_func"));
                f.setCargo(rs.getString("ds_cargos"));

                funcionarios.add(f);

            }

            rs.close();
            smt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return funcionarios;

    }

}
