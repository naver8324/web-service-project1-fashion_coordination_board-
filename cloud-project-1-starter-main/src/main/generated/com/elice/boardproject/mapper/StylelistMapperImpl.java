package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Stylelist;
import com.elice.boardproject.entity.StylelistDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T19:29:23+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class StylelistMapperImpl implements StylelistMapper {

    @Override
    public Stylelist stylelistPostDtoToStylelist(StylelistDto stylelistDto) {
        if ( stylelistDto == null ) {
            return null;
        }

        Stylelist stylelist = new Stylelist();

        stylelist.setLoginId( stylelistDto.getLoginId() );
        stylelist.setPassword( stylelistDto.getPassword() );
        stylelist.setNickname( stylelistDto.getNickname() );

        return stylelist;
    }
}
