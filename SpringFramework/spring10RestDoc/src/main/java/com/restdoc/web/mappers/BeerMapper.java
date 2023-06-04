package com.restdoc.web.mappers;

import com.restdoc.domain.Beer;
import com.restdoc.web.model.BeerDto;
import org.mapstruct.Mapper;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}
