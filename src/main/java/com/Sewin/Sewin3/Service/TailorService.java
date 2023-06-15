package com.Sewin.Sewin3.Service;

import java.util.List;

import com.Sewin.Sewin3.Model.Tailor;

public interface TailorService {
    List<Tailor> getAllTailors();

    Tailor saveTailor(Tailor tailor);

    Tailor getTailorById(Long id);

    Tailor updateTailor(Tailor tailor);

    void deleteTailorById(Long id);
}
