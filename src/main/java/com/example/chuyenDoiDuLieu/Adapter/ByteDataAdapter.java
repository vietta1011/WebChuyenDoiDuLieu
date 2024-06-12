package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ChuyenDoiDuLieu;
import org.springframework.stereotype.Component;

@Component
public class ByteDataAdapter implements ChuyenDoiDuLieu {
    @Override
    public byte[] Encode(Object duLieu) {
        if (duLieu instanceof byte[]) {
            return (byte[]) duLieu; // Trả về cùng một mảng byte nếu đầu vào là mảng byte
        } else if (duLieu instanceof String) {
            String[] byteValues = ((String) duLieu).split(",");
            byte[] byteArray = new byte[byteValues.length];
            for (int i = 0; i < byteValues.length; i++) {
                byteArray[i] = (byte) Integer.parseInt(byteValues[i].trim());
            }
            return byteArray;
        }
        throw new IllegalArgumentException("Invalid input type for encoding");
    }

    @Override
    public Object Decode(byte[] duLieuByte) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < duLieuByte.length; i++) {
            sb.append(duLieuByte[i]);
            if (i < duLieuByte.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
