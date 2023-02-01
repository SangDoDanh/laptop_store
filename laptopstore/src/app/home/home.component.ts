import {Component, OnInit} from '@angular/core';
import {ProductGroupDto} from '../dto/product-group-dto';
import {ProductGroupService} from '../service/product-group.service';
import {ProductGroupDetailDto} from '../dto/product-group-detail-dto';
import {FormBuilder, FormGroup, FormsModule} from '@angular/forms';
import {SizeInchDto} from '../dto/size-inch-dto';
import {SizeInchService} from '../service/size-inch.service';

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

  constructor(private productGroupService: ProductGroupService,
              private formBuilder: FormBuilder,
              private sizeInchService: SizeInchService) {
  }

  ngOnInit(): void {
    this.sizeInchService.getAll().subscribe(data => {
      this.sizeInchList = data;
    });

    this.rfSearch = this.formBuilder.group({
      producer: [''],
      nameSearch: [''],
      priceSearch: ['0,300000000'],
      inchSearch: [],
    });
    this.productGroupService.getAll().subscribe(data => {
      this.productGroups = data;
      this.productGroups.forEach(value => {
        value.urlImgs = value.urlImgs.split(',')[0];
      });
      data.forEach(value => {
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
    console.log(this.rfSearch.value.inchSearch);
    console.log(this.rfSearch.value.priceSearch);

    if (!this.rfSearch.value.inchSearch) {
      this.sizeInchValues = [];
      this.sizeInchList.forEach(value => {
        this.sizeInchValues.push(value.id);
      });
      this.rfSearch.value.inchSearch = this.sizeInchValues;
    } else {
      this.rfSearch.value.inchSearch = this.sizeInchValues;
    }
    this.productGroupService.search(this.rfSearch.value).subscribe(data => {
      this.productGroups = data;
      this.productGroups.forEach(value => {
        value.urlImgs = value.urlImgs.split(',')[0];
      });
      data.forEach(value => {
        this.productGroupService.getDetail(value.id).subscribe(productDetail => {
          this.productGroupDetail.push(productDetail);
        });
      });
    });
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
}
