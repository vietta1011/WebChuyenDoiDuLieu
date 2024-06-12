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

    @PostMapping("/encode")
    public ResponseEntity<?> encode(@RequestParam String type, @RequestBody String input) {
        Map<String, String> response = new HashMap<>();
        byte[] encodedData;
        try {
            switch (type) {
                case "byte":
                    encodedData = byteDataAdapter.Encode(input);
                    response.put("encoded", new String(encodedData));
                    return ResponseEntity.ok(response);
                case "hex":
                    encodedData = hexDataAdapter.Encode(input);
                    response.put("encoded", new String(encodedData));
                    return ResponseEntity.ok(response);
                case "base64":
                    encodedData = base64DataAdapter.Encode(input);
                    response.put("encoded", new String(encodedData));
                    return ResponseEntity.ok(response);
                case "string":
                    encodedData = stringDataAdapter.Encode(input);
                    response.put("encoded", new String(encodedData));
                    return ResponseEntity.ok(response);
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid encode type");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }

    @PostMapping("/decode")
    public ResponseEntity<?> decode(@RequestParam String type, @RequestBody String input) {
        Map<String, Object> response = new HashMap<>();
        byte[] inputBytes = input.getBytes();
        try {
            Object decodedData;
            switch (type) {
                case "byte":
                    decodedData = byteDataAdapter.Decode(inputBytes);
                    response.put("decoded", decodedData);
                    return ResponseEntity.ok(response);
                case "hex":
                    decodedData = hexDataAdapter.Decode(inputBytes);
                    response.put("decoded", decodedData);
                    return ResponseEntity.ok(response);
                case "base64":
                    decodedData = base64DataAdapter.Decode(inputBytes);
                    response.put("decoded", decodedData);
                    return ResponseEntity.ok(response);
                case "string":
                    decodedData = stringDataAdapter.Decode(inputBytes);
                    response.put("decoded", decodedData);
                    return ResponseEntity.ok(response);
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid decode type");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }
}
