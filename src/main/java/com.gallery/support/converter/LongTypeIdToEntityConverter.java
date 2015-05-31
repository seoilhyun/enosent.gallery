package com.gallery.support.converter;

import com.gallery.admin.core.domain.album.Album;
import com.gallery.admin.core.domain.album.Photo;
import com.gallery.admin.core.domain.common.ImageFile;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.util.NumberUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 2. 24.
 * Time: 오후 1:54
 * To change this template use File | Settings | File Templates.
 */
public class LongTypeIdToEntityConverter extends AbstractEntityConverter<Long> {

    @Override
    Set<ConvertiblePair> initConvertibleTypes() {
        Set<Class<?>> targetTypes = new HashSet<Class<?>>();

        targetTypes.add(ImageFile.class);
        targetTypes.add(Album.class);
        targetTypes.add(Photo.class);


        Set<ConvertiblePair> convertiblePairs = new HashSet<GenericConverter.ConvertiblePair>();

        for(Class<?> targetType : targetTypes) {
            convertiblePairs.add(new ConvertiblePair(Long.class, targetType));
            convertiblePairs.add(new ConvertiblePair(String.class, targetType));
        }

        return convertiblePairs;
    }

    @Override
    Long convertId(Object source, TypeDescriptor sourceType) {
        if(Long.class.equals(sourceType.getType())) {
            return (Long) source;
        } else {
            return NumberUtils.parseNumber(source.toString(), Long.class);
        }
    }
}
