package com.example.chuyenDoiDuLieu.Controller;

import com.example.chuyenDoiDuLieu.Adapter.Base64DataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.ByteDataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.HexDataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.StringDataAdapter;
import com.example.chuyenDoiDuLieu.Interface.ConvertData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DuLieuController {
    private ConvertData<String> getAdapterByType(String type) {
        switch (type) {
            case "byte":
                return ByteDataAdapter.getInstance();
            case "hex":
                return HexDataAdapter.getInstance();
            case "base64":
                return Base64DataAdapter.getInstance();
            case "string":
                return StringDataAdapter.getInstance();
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestParam String inputType, @RequestParam String outputType, @RequestBody String input) {
        Map<String, Object> response = new HashMap<>();
        try {
            ConvertData<String> inputAdapter = getAdapterByType(inputType);
            ConvertData<String> outputAdapter = getAdapterByType(outputType);

            byte[] encodedData = inputAdapter.Encode(input);
            Object decodedData = outputAdapter.Decode(encodedData);

            response.put("converted", decodedData);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }
}
