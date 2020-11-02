package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<>();
	private List<Jogador> jogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(times.stream().anyMatch(time -> time.getId() == id)) throw new IdentificadorUtilizadoException();

		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(jogadores.stream().anyMatch(jogador -> jogador.getId() == id)) throw new IdentificadorUtilizadoException();
		else if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		Jogador novoJogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);

		times.stream().filter(time -> time.getId() == idTime).forEach(time -> time.addJogador(novoJogador));

		jogadores.add(novoJogador);
	}

	public void definirCapitao(Long idJogador) {
		if(jogadores.stream().noneMatch(jogador -> jogador.getId() == idJogador)) throw new JogadorNaoEncontradoException();

		long idTime = jogadores.stream()
						.filter(jogador -> jogador.getId() == idJogador)
						.findFirst()
						.get()
						.getIdTime();

		times.stream()
				.filter(time -> time.getId() == idTime)
				.forEach(time -> time.setIdCapitao(idJogador));
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		Long idCapitao = times.stream()
				.filter(time -> time.getId() == idTime)
				.findFirst()
				.get()
				.getIdCapitao();

		if (idCapitao == null) throw new CapitaoNaoInformadoException();

		return idCapitao;
	}

	public String buscarNomeJogador(Long idJogador) {
		if(jogadores.stream().noneMatch(jogador -> jogador.getId() == idJogador)) throw new JogadorNaoEncontradoException();

		return jogadores.stream()
				.filter(jogador -> jogador.getId() == idJogador)
				.findFirst()
				.get()
				.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		return times.stream()
				.filter(time -> time.getId() == idTime)
				.findFirst()
				.get()
				.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		List<Long> idsJogadores = times.stream()
				.filter(time -> time.getId() == idTime)
				.findFirst()
				.get()
				.getJogadores()
				.stream()
				.map(Jogador::getId)
				.collect(Collectors.toList());

		Collections.sort(idsJogadores);
		return idsJogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		List<Jogador> jogadoresTime = times.stream()
				.filter(time -> time.getId() == idTime)
				.findFirst()
				.get()
				.getJogadores();

		Jogador melhorJogador = Collections.max(jogadoresTime, Comparator.comparing(Jogador::getNivelHabilidade));
		return melhorJogador.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		List<Jogador> jogadoresTime = times.stream()
				.filter(time -> time.getId() == idTime)
				.findFirst()
				.get()
				.getJogadores();

		Jogador jogadorMaisVelho = Collections.min(jogadoresTime, Comparator.comparing(Jogador::getDataNascimento));
		return jogadorMaisVelho.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> idsTimes = times.stream()
				.map(Time::getId)
				.collect(Collectors.toList());

		Collections.sort(idsTimes);
		return idsTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(times.stream().noneMatch(time -> time.getId() == idTime)) throw new TimeNaoEncontradoException();

		List<Jogador> jogadoresTime = times.stream()
				.filter(time -> time.getId() == idTime)
				.findFirst()
				.get()
				.getJogadores();

		Jogador jogadorMelhorSalario = Collections.max(jogadoresTime, Comparator.comparing(Jogador::getSalario));
		return jogadorMelhorSalario.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(jogadores.stream().noneMatch(jogador -> jogador.getId() == idJogador)) throw new JogadorNaoEncontradoException();

		return jogadores.stream()
				.filter(jogador -> jogador.getId() == idJogador)
				.findFirst()
				.get()
				.getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.limit(top)
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

}
