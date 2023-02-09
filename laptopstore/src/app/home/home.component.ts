import {Component, OnInit} from '@angular/core';
import {ProductGroupDto} from '../dto/product-group-dto';
import {ProductGroupService} from '../service/product-group.service';
import {ProductGroupDetailDto} from '../dto/product-group-detail-dto';
import {FormBuilder, FormGroup, FormsModule} from '@angular/forms';
import {SizeInchDto} from '../dto/size-inch-dto';
import {SizeInchService} from '../service/size-inch.service';
import {ProducerService} from '../service/producer.service';
import {ProducerForLapDto} from '../dto/producer-for-lap-dto';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isCheckedSizeInchAll = true;
  productGroups: ProductGroupDto[];
  productGroupDetail: ProductGroupDetailDto[] = [];
  rfSearch: FormGroup;
  sizeInchList: SizeInchDto[];
  sizeInchValues: number[] = [];
  producerForLap: ProducerForLapDto[];
  producerSearchValues: number[] = [];
  producerSearchValuesFull: number[] = [];
  // page info
  pageNumber = 0;
  totalPage: number;

  constructor(private productGroupService: ProductGroupService,
              private formBuilder: FormBuilder,
              private sizeInchService: SizeInchService,
              private producerService: ProducerService,
              private titleService: Title) {
  }

  ngOnInit(): void {
    this.titleService.setTitle('Trang chủ');
    this.rfSearch = this.formBuilder.group({
      producer: [],
      nameSearch: [''],
      priceSearch: ['0,300000000'],
      inchSearch: [],
    });
    this.producerService.getAllForLap().subscribe(dataProducer => {
      this.producerForLap = dataProducer;
      dataProducer.forEach(data => {
        this.producerSearchValuesFull.push(data.id);
      });
      this.sizeInchService.getAll().subscribe(data => {
        this.sizeInchList = data;
        this.pageBegin(this.pageNumber);
      });
    });
  }
  pageBegin(pageNumber: number) {
    if (!this.rfSearch.value.inchSearch) {
      this.sizeInchValues = [];
      this.sizeInchList.forEach(value => {
        this.sizeInchValues.push(value.id);
      });
      this.rfSearch.value.inchSearch = this.sizeInchValues;
    } else {
      this.rfSearch.value.inchSearch = this.sizeInchValues;
    }
    if (!this.rfSearch.value.producer) {
      this.rfSearch.value.producer = this.producerSearchValuesFull;
    }
    this.productGroupService.getAllAndSearchPage(this.rfSearch.value, pageNumber).subscribe(data => {
      this.pageNumber = data.pageable.pageNumber;
      console.log(data);
      this.totalPage = data.totalPages;
      this.productGroups = data.content;
      this.productGroups.forEach(value => {
        value.urlImgs = value.urlImgs.split(',')[0];
      });
      data.content.forEach(value => {
        this.productGroupService.getDetail(value.id).subscribe(productDetail => {
          this.productGroupDetail.push(productDetail);

        });
      });
    });
  }

  alo(id: number, isCheckedAll: any, indexCheck: any) {
    if (this.checkedSizeInch(indexCheck)) {
      isCheckedAll.checked = true;
      this.sizeInchValues = [];
      this.sizeInchList.forEach(value => {
        this.sizeInchValues.push(value.id);
      });
    } else {
      if (isCheckedAll.checked) {
        isCheckedAll.checked = false;
        this.sizeInchValues = [];
      }
      if (this.rfSearch.value.inchSearch && this.sizeInchValues.indexOf(id) === -1) {
        this.sizeInchValues.push(id);
      }
      if (!this.rfSearch.value.inchSearch && this.sizeInchValues.indexOf(id) > -1) {
        this.sizeInchValues.splice(this.sizeInchValues.indexOf(id), 1);
      }
    }
    this.rfSearch.value.inchSearch = this.sizeInchValues;
    this.search();
  }

  checkSizeAll(checkAllInput: any) {
    console.log(this.rfSearch.value);
    const isChecked = checkAllInput.target.checked;
    if (isChecked) {
      document.querySelectorAll('.check__sizeInch').forEach((value: any) => {
        if (value.checked) {
          value.checked = false;
        }
      });
      this.sizeInchValues = [];
      this.sizeInchList.forEach(value => {
        this.sizeInchValues.push(value.id);
      });
    } else {
      this.sizeInchValues = [];
    }
    this.rfSearch.value.inchSearch = this.sizeInchValues;
    this.search();
  }

  search() {
    this.setValueInitSearch();
    this.productGroupService.getAllAndSearchPage(this.rfSearch.value, 0).subscribe(data => {
      this.pageNumber = data.pageable.pageNumber;
      this.totalPage = data.totalPages;
      this.productGroups = data.content;
      this.productGroups.forEach(value => {
        value.urlImgs = value.urlImgs.split(',')[0];
      });
      data.content.forEach(value => {
        this.productGroupService.getDetail(value.id).subscribe(productDetail => {
          this.productGroupDetail.push(productDetail);

        });
      });
    });
  }
  setValueInitSearch() {
    console.log(this.rfSearch.value.producer);
    if (this.producerSearchValues.length === 0) {
      this.rfSearch.value.producer = this.producerSearchValuesFull;
    } else {
      this.rfSearch.value.producer = this.producerSearchValues;
    }
    if (!this.rfSearch.value.inchSearch) {
      this.sizeInchValues = [];
      this.sizeInchList.forEach(value => {
        this.sizeInchValues.push(value.id);
      });
      this.rfSearch.value.inchSearch = this.sizeInchValues;
    } else {
      this.rfSearch.value.inchSearch = this.sizeInchValues;
    }
    console.log('alo', this.rfSearch.value);
  }
  checkedSizeInch(indexCheck: any): boolean {
    this.isCheckedSizeInchAll = true;
    document.querySelectorAll('.check__sizeInch').forEach((value: any) => {
      if (value.checked) {
        this.isCheckedSizeInchAll = false;
      }
    });
    return this.isCheckedSizeInchAll;
  }

  setValueForSearchProducer(id: number, i: any) {
    document.querySelector('.menu__search--item-all').classList.remove('active');
    document.querySelector('.menu__search--item' + i).classList.toggle('active');
    if (this.producerSearchValues.indexOf(id) < 0) {
      this.producerSearchValues.push(id);
    } else {
      this.producerSearchValues.splice(this.producerSearchValues.indexOf(id), 1);
    }
    this.rfSearch.value.producer = this.producerSearchValues;
    console.log(this.rfSearch.value.producer);
    this.search();
  }

  searchAllProducer() {
    document.querySelectorAll('.menu__search--item').forEach(value => {
      value.classList.remove('active');
    });
    document.querySelector('.menu__search--item-all').classList.add('active');
    this.rfSearch.value.producer = this.producerSearchValuesFull;
    this.producerSearchValues = [];
    this.search();
  }

  viewMore(pageNumber: number) {
    this.setValueInitSearch();
    this.productGroupService.getAllAndSearchPage(this.rfSearch.value, pageNumber).subscribe(data => {
      this.pageNumber = data.pageable.pageNumber;
      this.totalPage = data.totalPages;
      data.content.forEach(value => {
        this.productGroups.push(value);
      });
      this.productGroups.forEach(value => {
        value.urlImgs = value.urlImgs.split(',')[0];
      });
      data.content.forEach(value => {
        this.productGroupService.getDetail(value.id).subscribe(productDetail => {
          this.productGroupDetail.push(productDetail);
        });
      });
    });
  }
}
