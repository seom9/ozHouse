package com.oz.ozHouse.merchant.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerJoinRepositoryImpl implements MerJoinRepository{
	private final EntityManager em;

	public MerchantDTO findMerchantComnum(Map<String, String> comNum) {
		//Query 작성
		System.out.println("merComnum1 : " + comNum.get("merComnum1"));
		System.out.println("merComnum2 : " + comNum.get("merComnum2"));
		System.out.println("merComnum3 : " + comNum.get("merComnum3"));
		String query = 
				"SELECT m FROM Merchant m where m.merComnum.merComnum1 = :value1 "
				+ "AND m.merComnum.merComnum2 = :value2 "
				+ "AND m.merComnum.merComnum3 = :value3";
		//Query 생성
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
		        .setParameter("value1", comNum.get("merComnum1"))
		        .setParameter("value2", comNum.get("merComnum2"))
		        .setParameter("value3", comNum.get("merComnum3"));
		
		//결과 조회
		MerchantDTO dto = new MerchantDTO();
		try {
			Merchant m = jpql.getSingleResult();
			dto = dto.toDto(m);
		}catch(NoResultException e) {
			dto = null;
			return dto;
		}
		return dto;
	}

	public MerchantDTO findMerchantEmail(String email) {
		// Query 작성
		String query = "SELECT m FROM Merchant m where m.merEmail = :value1";
		// Query 생성
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
				.setParameter("value1", email);

		// 결과 조회
		MerchantDTO dto = new MerchantDTO();
		try {
			Merchant m = jpql.getSingleResult();
			dto = dto.toDto(m);
		}catch(NoResultException e) {
			dto = null;
			return dto;
		}
		return dto;
	}

	public MerchantDTO findMerchantId(String id) {
		String query = "SELECT m FROM Merchant m where m.merId = :value";
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
				.setParameter("value", id);
		// 결과 조회
		MerchantDTO dto = new MerchantDTO();
		try {
			Merchant m = jpql.getSingleResult();
			dto = dto.toDto(m);
		}catch(NoResultException e) {
			dto = null;
			return dto;
		}
		return dto;
	}

	@Override
	public <S extends Merchant> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Merchant> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Merchant> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Merchant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Merchant getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Merchant> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Merchant> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Merchant> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Merchant> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Merchant entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Merchant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Merchant> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Merchant> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Merchant> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Merchant> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Merchant> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Merchant> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Merchant, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}


}