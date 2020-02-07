package com.swagger2.demo;

import com.swagger2.demo.model.Language;
import com.swagger2.demo.repository.ILanguageRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    private final ILanguageRepository languageRepository;

    public void initData() {
        try {
            Language language = new Language();
            language.setName("Java");
            languageRepository.save(language);

            language = new Language();
            language.setName("JavaScript");
            languageRepository.save(language);

            language = new Language();
            language.setName("C++");
            languageRepository.save(language);

            language = new Language();
            language.setName("Groovy");
            languageRepository.save(language);

            language = new Language();
            language.setName("Python");
            languageRepository.save(language);

            language = new Language();
            language.setName("Swift");
            languageRepository.save(language);

        }catch (final Exception ex){
            logger.error("Exception while inserting mock data {}", ex);
        }
    }
}
