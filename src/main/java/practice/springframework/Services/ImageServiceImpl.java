package practice.springframework.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import practice.springframework.Models.Recipe;
import practice.springframework.Repositories.RecipeRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObject = new Byte[file.getBytes().length];

            int i=0;

            for(byte b: file.getBytes()){
                byteObject[i++]=b;
            }
            recipe.setImage(byteObject);

            recipeRepository.save(recipe);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
