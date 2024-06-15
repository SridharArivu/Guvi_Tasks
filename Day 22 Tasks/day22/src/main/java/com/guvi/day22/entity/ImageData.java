package com.guvi.day22.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "images")
public class ImageData {
    @Id
    private ObjectId id;
    private String email;
    private String name;
    private String type;
    private byte[] imageData;
}
