I=imread('lenna.bmp');
figure(1);
imshow(I);%��ʾͼ��I

figure(2);

fid=fopen('cell_128.img','r');    %���޸�ʽ�ļ�
data1=(fread(fid,[128,128],'uint8')); %���򿪵��ļ����뵽data1
subplot(2,2,1)                         %��figure(1)�ֳ�2*2��4���Ӵ���,
imshow(data1,[0 255]);                %��ʾʱ�轫double��ת��Ϊ����
title('CELL 1','Color','b');            %�ӱ���

fid=fopen('fing_128.img','r'); %���޸�ʽ�ļ�
data3=(fread(fid,[128,128],'uint8'))';%���򿪵��ļ����뵽data3
data3=uint8(data3);%���Ҷ�ͼ��ת����uint8��ʽ
subplot(2,2,2);    %ȡ�ڶ����Ӵ���
imshow(data3);%��ʾ�Ҷ�ͼ��
title('finger 2','Color','b');

fid=fopen('Lena_256.img','r');
data4=(fread(fid,[256,256],'uint8'))';
subplot(2,2,3)
imagesc(data4);
colormap(gray);
title('LENA 3','Color','r');

figure(3);
I1=zeros(128,128);%����һ��128��128��ȫ��ͼ��
for i=38:1:90
    for j=58:1:70
        I1(i,j)=255;%��I1(i,j)=1��
    end
end
imshow(I1);%I1��Ϊ����ͼ�Ρ�
imwrite(I1,'output.bmp');


