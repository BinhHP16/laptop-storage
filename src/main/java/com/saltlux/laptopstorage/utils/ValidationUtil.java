package com.saltlux.laptopstorage.utils;

import com.saltlux.laptopstorage.exeption.BadRequestException;
import com.saltlux.laptopstorage.utils.constraints.AppConstants;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String FULLNAME_PATTERN =
            "[ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
                    "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
                    "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+";

    public void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if (size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }

    public static boolean isValidId(Integer id) {
        return id != null && id > 0;
    }

    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }

    public static <T> boolean isListNullOrEmpty(List<T> list) {
        return null == list || list.isEmpty();
    }

    public static boolean isTrue(Boolean value) {
        return value != null && value;
    }

    public static boolean isPositiveId(Integer value) {
        return value != null && value > 0;
    }

    public static boolean isEmptyString(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean hasVietnamCharacter(String input) {
        Pattern pattern = Pattern.compile(FULLNAME_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }


    public static boolean isCollectionNullOrEmpty(Collection c) {
        return Objects.isNull(c) || c.size() == 0;
    }
}