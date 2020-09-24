package br.com.ifce.testes;

import java.util.List;

import br.com.ifce.dao.ColetaDAO;
import br.com.ifce.model.Coleta;

public class TestesClassesDao {

	public static void main(String[] args) {

		// ------- Cadastrar laboratorio e dois usuarios (Cadastro e Responsável Técnico)
		/*
		Laboratorio laboratorio = new Laboratorio(null, "Clinic Bad Code", 500);
		
		Usuario cadastro = new Usuario(null, "Cadastro", 123L, LocalDate.of(2000, 5, 25), "Rua 1", "Fortaleza", "ceará", TipoUsuario.CADASTRO, "cadastro", "cadastro", laboratorio);
		Usuario responsavelTecnico = new Usuario(null, "Responsavel Técnico", 999L, LocalDate.of(1998, 8, 5), "Rua 1", "Fortaleza", "ceará", TipoUsuario.RESPONSAVEL_TECNICO, "rt", "rt", laboratorio);

		LaboratorioDAO.getInstance().persist(laboratorio);
		UsuarioDAO.getInstance().persist(cadastro);
		UsuarioDAO.getInstance().persist(responsavelTecnico);
		*/
		
		// ------- Alterar o Número de Testes do Laboratório
		/*
		Laboratorio laboratorio = new Laboratorio(1L, "Clinic Bad Code", 450);
		LaboratorioDAO.getInstance().merge(laboratorio);
		*/
		
		// ------- Mostrar logins e senha de todos os usuarios
		/*
		List<Usuario> usuarios = UsuarioDAO.getInstance().findAll();
		usuarios.stream().forEach(usuario -> System.out.println("Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha()));
		*/
		
		// ------- Cadastar um paciente e fazer uma coleta (USUARIO CADASTRO)
		/*
		Paciente paciente1 = new Paciente(null, "Naruto", 465L, LocalDate.of(2010, 8, 1), "Rua zero", "São Paulo", "São Paulo", "");
		Coleta coleta1 = new Coleta(null, "João", TipoColeta.ASPIRADO_NASO_FARINGIEO, paciente1);
		
		PacienteDAO.getInstance().persist(paciente1);
		ColetaDAO.getInstance().persist(coleta1);
		 */
		
		// ------- Cadastar um paciente e fazer uma coleta (USUARIO RESPONSÁVEL TÉCNICO)
			//obs.: é necessário buscar o paciente e o responsável técnico antes;
		/*
		Paciente paciente = PacienteDAO.getInstance().getById(1L); //Definir método de buscar do paciente (cpf?, id?)
		Usuario responsavelTecnico = UsuarioDAO.getInstance().getById(2L); //Definir método de buscar do usuario (cpf?, id?)
		Exame exame1 = new Exame(null, LocalDate.now(), Conclusao.NAO_DETECTADO, paciente, responsavelTecnico);
		ExameDAO.getInstance().persist(exame1);
		*/
		
		// ------- Cadastrar Supervisor
		/*
		Laboratorio laboratorio = new Laboratorio(1L, "Clinic Bad Code", 500);
		Usuario supervisor = new Usuario(null, "Supervisor", 888L, LocalDate.of(2001, 12, 10), "rua lima", "Acarape", "Ceara", TipoUsuario.SUPERVISOR, "supervisor", "supervisor", laboratorio);
		
		UsuarioDAO.getInstance().persist(supervisor);
		*/
		
		// ------- Busca dos pacientes a partir da Coleta
		/*
		List<Coleta> coletas = ColetaDAO.getInstance().findAll();
		coletas.stream().forEach(e -> System.out.println(e.getPaciente().getNome()));
		*/
		}						
}
