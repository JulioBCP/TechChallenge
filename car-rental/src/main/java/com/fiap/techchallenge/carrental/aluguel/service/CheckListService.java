package com.fiap.techchallenge.carrental.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.aluguel.DTO.AtualizarCheckListDTO;
import com.fiap.techchallenge.carrental.aluguel.entity.CheckList;
import com.fiap.techchallenge.carrental.aluguel.repository.CheckListRepository;

@Service
public class CheckListService {

   @Autowired
   CheckListRepository checkListRepository;

   // creat
   public CheckList inserirCheckList(CheckList checkList) {
      return checkListRepository.save(checkList);
   }

   // read
   public CheckList encontrarCheckList(long id) {
      return checkListRepository.getReferenceById(id);
   }

   // update
   public CheckList alterarCheckList(AtualizarCheckListDTO atualizaCheckList, long id) {
      CheckList checkList = checkListRepository.getReferenceById(id);
      checkList.setAbastecido(atualizaCheckList.abastecido());
      checkList.setPressaoPneus(atualizaCheckList.pressaoPneus());
      checkList.setAvariasPintura(atualizaCheckList.avariasPintura());
      checkList.setAvariasInterna(atualizaCheckList.avariasInterna());
      checkList.setLimpeza(atualizaCheckList.limpeza());
      checkList.setKm(atualizaCheckList.km());

      return checkListRepository.save(checkList);
   }

   // delete
   public void deletarCheckList(long id) {
      checkListRepository.deleteById(id);
   }

}
