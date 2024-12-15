package com.tesinitsyn.exhibitionservice.service;

import com.tesinitsyn.exhibitionservice.repository.ExhibitionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Сервис выставок.
 */
@Log4j2
@Service
@AllArgsConstructor
public class ExhibitionService {


    private ExhibitionRepository exhibitionRepository;



}
