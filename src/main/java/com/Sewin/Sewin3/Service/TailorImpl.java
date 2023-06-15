package com.Sewin.Sewin3.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Sewin.Sewin3.Model.Tailor;
import com.Sewin.Sewin3.Repository.TailorRepository;

@Service
public class TailorImpl implements TailorService {

    private TailorRepository tailorRepository;

    public TailorImpl(TailorRepository tailorRepository) {
        super();
        this.tailorRepository = tailorRepository;
    }

    @Override
    public List<Tailor> getAllTailors() {
        return tailorRepository.findAll();
    }

    @Override
    public Tailor saveTailor(Tailor tailor) {
        return tailorRepository.save(tailor);
    }

    @Override
    public Tailor getTailorById(Long id) {
        return tailorRepository.findById(id).orElse(null);
    }

    @Override
    public Tailor updateTailor(Tailor tailor) {
        return tailorRepository.save(tailor);
    }

    @Override
    public void deleteTailorById(Long id) {
        tailorRepository.deleteById(id);
    }
}
