from keras.models import load_model
import numpy as np
from keras.preprocessing import image
from os.path import dirname, join

def main():
    modelF=join(dirname(__file__),"cats&dog.h5")
    picF=join(dirname(__file__),"pic01.jpg")
    model=load_model(modelF)
    test_image=image.load_img(picF,target_size=(64,64))
    test_image=image.img_to_array(test_image)
    test_image=np.expand_dims(test_image, axis=0)
    result=model.predict(test_image)
    if result[0][0]==1:
        prediction='這是個-Dog'
        print(prediction)
        return prediction
    else:
        prediction='這是-Cat'
        print(prediction)
        return prediction


def myFun(o):
    a = o+10    
    return a

def myClear():
    return "等待"
