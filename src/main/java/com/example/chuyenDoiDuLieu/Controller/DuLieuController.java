package com.example.chuyenDoiDuLieu.Controller;

import com.example.chuyenDoiDuLieu.Interface.ChuyenDoiDuLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DuLieuController {
    @Autowired
    private ChuyenDoiDuLieu base64DataAdapter;

    @Autowired
    private ChuyenDoiDuLieu hexDataAdapter;

    @Autowired
    private ChuyenDoiDuLieu stringDataAdapter;

    @Autowired
    private ChuyenDoiDuLieu byteDataAdapter;

    private ChuyenDoiDuLieu getAdapterByType(String type) {
        switch (type) {
            case "byte":
                return byteDataAdapter;
            case "hex":
                return hexDataAdapter;
            case "base64":
                return base64DataAdapter;
            case "string":
                return stringDataAdapter;
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestParam String inputType, @RequestParam String outputType, @RequestBody String input) {
        Map<String, Object> response = new HashMap<>();
        try {
            ChuyenDoiDuLieu inputAdapter = getAdapterByType(inputType);
            ChuyenDoiDuLieu outputAdapter = getAdapterByType(outputType);

            byte[] encodedData = inputAdapter.Encode(input);
            Object decodedData = outputAdapter.Decode(encodedData);

            response.put("converted", decodedData);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }
}
