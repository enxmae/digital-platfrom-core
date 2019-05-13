package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.constants.TourProgress;
import com.dvfu.digital_platform_core.dao.*;
import com.dvfu.digital_platform_core.repository.TourProductRepository;
import com.dvfu.digital_platform_core.repository.TourRepository;
import com.dvfu.digital_platform_core.service.TourService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final TourProductRepository tourProductRepository;

    TourServiceImpl(TourRepository tourRepository, TourProductRepository tourProductRepository) {
        this.tourProductRepository = tourProductRepository;
        this.tourRepository = tourRepository;
    }

    public TourResponse findTourById(Long id){
        Tour tour = tourRepository.findTourById(id);
        List<ToursProducts> products = tourProductRepository.findAllByTour_Id(id);

        return createTourResponse(tour, products);

    }

    @Override
    public List<TourResponse> findAll() {
        List<Tour> tours = tourRepository.findAllByTourProgress(TourProgress.OK);
        List<TourResponse> tourResponses = new ArrayList<>();

        for(Tour tour : tours) {
            List<ToursProducts> products = tourProductRepository.findAllByTour_Id(tour.getId());
            tourResponses.add(createTourResponse(tour, products));
        }

        return tourResponses;
    }

    @Override
    public List<TourResponse> findAll(Long ownerId) {
        List<Tour> tours = tourRepository.findAllByOwner_Id(ownerId);
        List<TourResponse> tourResponses = new ArrayList<>();

        for(Tour tour : tours) {
            List<ToursProducts> products = tourProductRepository.findAllByTour_Id(tour.getId());
            tourResponses.add(createTourResponse(tour, products));
        }

        return tourResponses;
    }

    public Tour insert(TourRequest tourRequest) {
        Tour tour = new Tour();
        tour = createTour(tourRequest);
        tour.setTourProgress(TourProgress.IN_PROGRESS);

        tourRepository.save(tour);

        for(int i = 0; i < tourRequest.getProducts().size(); i++) {
            TourProduct tourProduct = new TourProduct(tour, tourRequest.getProducts().get(i), TourProgress.IN_PROGRESS);
            tourProductRepository.save(tourProduct);
        }

        return tour;
    }

    @Override
    public List<ToursProducts> test(Long tourId) {
        return tourProductRepository.findAllByTour_Id(tourId);
    }

    @Override
    public TourResponse createTourResponse(Tour tour, List<ToursProducts> products) {
        TourResponse tourResponse = new TourResponse();

        tourResponse.setId(tour.getId());
        tourResponse.setDescription(tour.getDescription());
        tourResponse.setTitle(tour.getTitle());
        tourResponse.setOwner(tour.getOwner());
        tourResponse.setTourProgress(tour.getTourProgress());
        tourResponse.setProducts(products);

        return tourResponse;

    }

    @Override
    public Tour createTour(TourRequest tourRequest) {
        Tour tour = new Tour();

        tour.setId(tourRequest.getId());
        tour.setTourProgress(tourRequest.getTourProgress());
        tour.setTitle(tourRequest.getTitle());
        tour.setDescription(tourRequest.getDescription());
        tour.setOwner(tourRequest.getOwner());

        return tour;
    }

    @Override
    public boolean checkTourProgressOK(Long tourId) {
        List<ToursProducts> products = tourProductRepository.findAllByTour_Id(tourId);

        Integer OKCounter = 0;

        for(ToursProducts product : products) {
            if(product.getTourProgress().equals(TourProgress.OK)){
                OKCounter += 1;
            }
        }

        return OKCounter.equals(products.size());
    }

    @Override
    public TourProduct setProductProgress(TourProduct tourProduct) {
        TourProduct tourProductFromDB = tourProductRepository.findByTour_IdAndProduct_Id(tourProduct.getTour().getId(),
                        tourProduct.getProduct().getId());

        BeanUtils.copyProperties(tourProduct, tourProductFromDB, "id");
        tourProductRepository.save(tourProductFromDB);


        if(checkTourProgressOK(tourProductFromDB.getTour().getId())) {
            setOKStatus(tourProductFromDB.getTour());
        } else{
            setInProgressStatus(tourProductFromDB.getTour());
        }

        return tourProductFromDB;
    }

    private void setOKStatus(Tour tour) {
        tour.setTourProgress(TourProgress.OK);
        tourRepository.save(tour);
    }

    private void setInProgressStatus(Tour tour) {
        tour.setTourProgress(TourProgress.IN_PROGRESS);
        tourRepository.save(tour);
    }

}
