package com.example.chuyenDoiDuLieu.Interface;

import org.springframework.stereotype.Service;

@Service
public interface ChuyenDoiDuLieu {
    byte[] Encode(Object duLieu);
    Object Decode(byte[] duLieuByte);
}
