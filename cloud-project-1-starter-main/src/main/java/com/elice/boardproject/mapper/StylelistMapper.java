package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Stylelist;
import com.elice.boardproject.entity.StylelistDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StylelistMapper {

    Stylelist stylelistPostDtoToStylelist(StylelistDto stylelistDto);
}
